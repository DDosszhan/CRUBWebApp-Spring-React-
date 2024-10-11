import React, { useEffect, useState } from 'react';
import { deleteEmployee, listEmployees } from '../services/EmployeeService';
import { useNavigate } from 'react-router-dom';


const ListEmployeeComponent = () => {
  const [employees, setEmployees] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  const navigator = useNavigate();

  useEffect(() => {
    getAllEmployees();
  }, []);

  function getAllEmployees () {
    listEmployees()
      .then((response) => {
        setEmployees(response.data);
        setLoading(false);
      })
      .catch((error) => {
        console.error(error);
        setError('Failed to fetch employees.');
        setLoading(false);
      });
  }

  if (loading) return <div>Loading...</div>;
  if (error) return <div>{error}</div>;


  function addNewEmployee(){
    navigator('/add-employee');
  }

  function updateEmployee (id) {
    navigator(`/edit-employee/${id}`);
  }

  function removeEmployee(id) {
    console.log(id);

    deleteEmployee(id).then((response) => {
      getAllEmployees();
    }).catch(error => {
      console.error(error);
    })
  }
  return (
    <div className='container'>
      <h2 className='text-center'>List of Employees</h2>
      <button className='btn btn-primary mb-2' onClick={addNewEmployee}>Add Employee</button>
      <table className='table table-striped table-bordered'>
        <thead>
          <tr>
            <th>Employee Id</th>
            <th>Employee First Name</th>
            <th>Employee Last Name</th>
            <th>Employee Email Id</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
          {employees.length > 0 ? (
            employees.map((employee) => (
              <tr key={employee.id}>
                <td className='text-center'>{employee.id}</td>
                <td className='text-center'>{employee.firstName}</td>
                <td className='text-center'>{employee.lastName}</td>
                <td className='text-center'>{employee.email}</td>
                <td>
                <button type='button' 
                  className='btn btn-info'
                  onClick={() => updateEmployee(employee.id)}>Update</button>
                <button type='button' 
                className='btn btn-danger'
                onClick={() => removeEmployee(employee.id)}
                style={{marginLeft: '10px'}}>Delete</button>
                </td>
              </tr>
            ))
          ) : (
            <tr>
              <td colSpan="4">No employees found</td>
            </tr>
          )}
        </tbody>
      </table>
    </div>
  );
};

export default ListEmployeeComponent;
