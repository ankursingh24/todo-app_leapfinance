import React,  {useEffect,useState} from 'react'
import { showLists ,deleteList} from '../services/ListService'
import { useNavigate } from 'react-router-dom'
const ListComponent = () => {
  const [lists,setList]=useState([])

  const navigator=useNavigate();

useEffect(()=>{
    getAllList();
    
},[])


function getAllList(){
  showLists().then((response)=>{
    setList(response.data)
  }).catch(error=>{
    console.error(error);
  })
}





function addNewTask(){
  navigator('/add-task')
}

function removeList(id){
  console.log(id);
  deleteList(id).then((response)=>{
     getAllList();
  }).catch(error=>{
  console.error(error);
  })
}


function updateList(id){
  navigator(`/edit-task/${id}`)
}

  // use state allows usto use state variables in functional component

  return (
    <div  className='container'>
      <h2 className='text-center'>TO-DO List</h2>
      <button className='btn btn-primary mb-2' onClick={addNewTask}>Add New Task</button>
      <table className="table table-stripped table-bordered">
        <thead>
          <tr class="table-dark">
            <th>id</th>
            <th>Task</th>
            <th>Description</th>
            <th>Status</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
          {
            lists.map(list=>
              <tr key={list.id}>
                <td>{list.id}</td>
                <td>{list.task}</td>
                <td>{list.description}</td>
                <td>{list.status}</td>
                <td>
                  <button className='btn btn-info' style={{marginLeft:'15px'}} onClick={()=>updateList(list.id)}>Update</button>
                  <button className='btn btn-danger' style={{marginLeft:'10px'}}  onClick={()=>removeList(list.id)}>Delete</button>
                </td>
              </tr>
              )
          }
        </tbody>

      </table>
    </div>
  )
}

export default ListComponent