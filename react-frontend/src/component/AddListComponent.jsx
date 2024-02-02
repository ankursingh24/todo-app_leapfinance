import React, { useEffect, useState } from 'react'
import { createList, getList ,updateList} from '../services/ListService'
import { useNavigate,useParams} from 'react-router-dom'
//use param rejects key-value pair
 

const AddListComponent = () => {
    const [task, setTask] = useState('')
    const [description, setDescription] = useState("")
    const [status, setStatus] = useState("Not Completed")


    const {id}=useParams();
    const [error, setError] = useState({
        task:'',
        description:'',
        status:''
    })

    const handleTask = (e) => setTask(e.target.value);
    const handleDescription = (e) => setDescription(e.target.value);
    const handleStatus = (e) => setStatus(e.target.value);

    const navigator = useNavigate();

    useEffect(()=>{

    if(id){
        getList(id).then((response)=>{
            setTask(response.data.task);
            setDescription(response.data.description);
            setStatus(response.data.status);
        })
    .catch(error =>{
        console.error(error);

    })
    }
 }, [id] )




    function saveOrUpdateTask(e) {
        e.preventDefault();

        const todo = { task, description, status };
        console.log(todo)


       if(validateForm())
        {
        if(id){
            updateList(id,todo).then( (response)=>{
                console.log(response.data);
                navigator('/lists')
            }).catch(error=>{
                console.error(error);
            })

            }
            else{
        
    
            
        

        createList(todo).then((response) => {
            console.log(response.data);
            navigator('/lists')
        })}
    }
        else{
            window.alert("Fill the info properly");
        }
    
    }

    

    function validateForm() {
        let valid = true;
        const errorsCopy = { ...error }

        if (task.trim()) {
            errorsCopy.task = '';
        }
        else {
            errorsCopy.task = 'Task is required';
            valid = false;
        }

        if (description.trim()) {
            errorsCopy.description = '';
        }
        else {
            errorsCopy.description = 'Description is required';
            valid = false;
        }

        if (status.trim()) {
            errorsCopy.status = '';
        }
        else {
            errorsCopy.status = 'status is required';
            valid = false;
        }

        setError(errorsCopy);
        return valid;

    }

    function pageTitle(){
        if(id){
            return <h2  className='text-center'>Update Task</h2>
        }
        else{
            return <h2 className='text-center' style={{ margin: '5px' }}>ADD TASK</h2>
        }
    }



    return (



        <div className='container'>
            <br />
            <br />
            <br />
            <div className='row'>

                <div className='card col-md-6 offset-md-3 offset md-3'>
                    {
    pageTitle()
                    }
                    <div className='card-body'>
                        <form  >
                            <div className='form-group-2'>
                                <label className='form-label'>Task:
                                </label>
                                <input
                                    type='text'
                                    placeholder='Enter the task'
                                    name='task'
                                    value={task}
                                    className={'form-control'}
                                    onChange={handleTask}

                                ></input>
                            </div>

                            <div className='form-group-2' style={{ padding: '5px' }}>
                                <label className='form-label'>Description :
                                </label>
                                <input
                                    type='text'
                                    placeholder='Enter the Description'
                                    name='description'
                                    value={description}
                                    className='form-control'
                                    onChange={handleDescription}
                                ></input>
                            </div>

                            <div className='form-group-2'>
                                <label className='form-label'>Status:
                                </label>
                                <input
                                    type='text'
                                    placeholder='Not '
                                    name='status'
                                    value={status}
                                    className='form-control'
                                    onChange={handleStatus}
                                ></input>
                            </div>
                            <br></br>
                            <button className='btn btn-primary' onClick={saveOrUpdateTask}>Submit</button>
                        </form>
                    </div>


                </div>
            </div>

        </div>
    )

                }
export default AddListComponent