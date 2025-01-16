import React, {useEffect, useState} from 'react'
import { deleteEmployee, listEmployees } from '../services/EmployeService'
import { useNavigate } from 'react-router-dom'

const ListEmployeeComponent = () => {
 
    const [employee, setEmployees] = useState([])

    const navigator = useNavigate();

    useEffect(()=> {
        getAllEmployees();
    }, [])

    function getAllEmployees(){
        listEmployees().then((Response) => {
            setEmployees(Response.data);
            }).catch(error =>{
                console.error(error);
            })
    }
   
    function addNewEmployee (){
        navigator('/add-employee')
    }

    function updateEmployee(id){
        navigator(`/edit-employee/${id}`)
    }

    function removeEmployee(id){
        console.log(id);

        deleteEmployee(id).then((Response)=>{
            getAllEmployees();
        }).catch(error => {
            console.error(error);
        })
    }
  return (
    <div className='container'>
        <h2 className='text-center'>List of Employee</h2>
        <button className='btn btn-primary' onClick={addNewEmployee}>Add Employee</button>
        <table className='table table-striped table-border'>
            <thead>
                <tr>
                    <th>Employee Id</th>
                    <th>Employee first name</th>
                    <th>Employee last name</th>
                    <th>Employee email Id</th>
                    <th>Actions</th>

                </tr>
            </thead>
            <tbody>
                {
                    employee.map(employee =>
                       <tr key={employee.id}>
                            <td>{employee.id}</td>
                            <td>{employee.firstName}</td>
                            <td>{employee.lastName}</td>
                            <td>{employee.email}</td>
                            <td>
                                <button className='btn btn-info'onClick={ () => updateEmployee(employee.id)}>Update</button>
                                <button className='btn btn-danger'onClick={ () => removeEmployee(employee.id)}
                                    style={{marginLeft:'10px'}}
                                    >Delete</button>

                            </td>
                        </tr>
                    )
                }
            </tbody>
        </table>
    </div>
  )
}

export default ListEmployeeComponent