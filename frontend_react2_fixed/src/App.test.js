import { render, screen, fireEvent, waitFor } from '@testing-library/react';
import fetchMock from 'jest-fetch-mock';
import App from './App';

describe('App component', () => {

  beforeEach(() => {
    fetchMock.resetMocks();
  });

  /**
  *  #1 Testet das Rendern der Überschrift.
  */
  test('renders heading', () => {
    render(<App />);
    const headingElement = screen.getByRole('heading', { name: /ToDo Liste/i });
    expect(headingElement).toBeInTheDocument();
  });

  /**
  *  #2 Testet das Hinzufügen einer Aufgabe.
  */
test('allows user to add a new task', async () => {
  fetchMock
    .mockResponseOnce(JSON.stringify([])) // componentDidMount
    .mockResponseOnce(JSON.stringify({})); // POST /tasks

  render(<App />);
  const inputElement = screen.getByLabelText(/Enter new Task/i);
  const addButtonElement = screen.getByRole('button', { name: /Save/i });
  const taskName = 'Buy_groceries';

  fireEvent.change(inputElement, { target: { value: taskName } });
  fireEvent.click(addButtonElement);

  await waitFor(() => {
    const newTaskElement = screen.getByText(/Buy_groceries/);
    expect(newTaskElement).toBeInTheDocument();
  });
});

  /**
   * #3 Überprüft, ob die Komponente nach dem Rendern die korrekten Startzustände aufweist.
   */
  test('renders with initial state', () => {
    render(<App />);
    const inputElement = screen.getByLabelText(/Enter new Task/i);
    const addButtonElement = screen.getByRole('button', { name: /Save/i });

    expect(inputElement).toHaveValue('');
    expect(addButtonElement).toBeInTheDocument();
    expect(screen.queryByText(/Task 1:/)).not.toBeInTheDocument();
  });

  /**
   * #4 Überprüft, ob das Hinzufügen mehrerer Aufgaben nacheinander korrekt funktioniert.
   */
 test('allows user to add multiple tasks', async () => {
  fetchMock
    .mockResponseOnce(JSON.stringify([])) // componentDidMount
    .mockResponseOnce(JSON.stringify({})) // first POST
    .mockResponseOnce(JSON.stringify({})); // second POST

  render(<App />);
  const inputElement = screen.getByLabelText(/Enter new Task/i);
  const addButtonElement = screen.getByRole('button', { name: /Save/i });

  fireEvent.change(inputElement, { target: { value: 'Buy_groceries' } });
  fireEvent.click(addButtonElement);

  await waitFor(() => {
    expect(screen.getByText(/Task 1: Buy_groceries/)).toBeInTheDocument();
  });

  fireEvent.change(inputElement, { target: { value: 'Do_laundry' } });
  fireEvent.click(addButtonElement);

  await waitFor(() => {
    expect(screen.getByText(/Task 2: Do_laundry/)).toBeInTheDocument();
  });
});

  /**
   * #5 Testet Laden der Tasks vom Backend (Mock)
   */
test('loads and displays tasks after fetch', async () => {
  fetchMock.mockResponseOnce(
    JSON.stringify([
      { taskdescription: 'Buy_groceries' },
      { taskdescription: 'Do_laundry' }
    ])
  );

  render(<App />);

  await waitFor(() => {
    expect(screen.getByText(/Task 1: Buy_groceries/i)).toBeInTheDocument();
    expect(screen.getByText(/Task 2: Do_laundry/i)).toBeInTheDocument();
  });
});

});