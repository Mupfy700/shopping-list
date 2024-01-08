import axios from 'axios';

const API_URL = 'http://localhost:8080/todos';


const getTodos = () => axios.get(`${API_URL}/list`);

const getTodoByName = (id) => axios.get(`${API_URL}/${id}`);
const addTodo= (newTodo) => axios.post(`${API_URL}/addTodo`, newTodo);
const deleteTodo = (id) => axios.delete(`${API_URL}/delete/${id}`);

export { getTodos, addTodo, deleteTodo };