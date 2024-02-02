import axios from "axios";

const REST_API_BASE_URL='http://localhost:8080/api/lists';

export const showLists =()=>axios.get(REST_API_BASE_URL);

export const createList=(list)=>axios.post(REST_API_BASE_URL,list);
export const getList=(listId)=>axios.get(REST_API_BASE_URL+ '/' +listId);
export const updateList=(listId,list)=>axios.put(REST_API_BASE_URL+ '/' +listId,list);
export const deleteList=(listId)=>axios.delete(REST_API_BASE_URL+ '/' +listId);


