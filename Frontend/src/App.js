import React,{Component} from 'react';

import {BrowserRouter as Router, Route} from 'react-router-dom';

import axios from 'axios';
import Todos from './components/Todos';
import AddTodo from './components/AddTodo';

import Header from './components/layout/Header';
import About from  './components/pages/About';
import './App.css';

import { v4 as uuidv4 } from 'uuid';

class App extends Component{
  state={
    todos:[]
  }
  componentDidMount(){
    axios.get('http://localhost:8181/api/vi/todo/').then(res=>
    this.setState({todos:res.data})
    );
  }
  //search By title
  filerTodo=(searchKey)=>{
    if(searchKey.length>0){
      this.setState({
        
        todos:[...this.state.todos.filter(todo=>todo.title.toLowerCase().includes(searchKey.toLowerCase()))]
      });

    }else{this.componentDidMount()}
    
  }
  //Toggle Completed
  markComplete=(id)=>{
   // console.log(id);
   //axios.delete(`http://localhost:8181/api/vi/todo/${id}/${!todo.completed}`)
    this.setState({
      todos: this.state.todos.map(todo=>{
        if(todo.id === id) {
          var completed=todo.completed;
          todo.completed = !completed;
          axios.put(`http://localhost:8181/api/vi/todo/${id}/${!completed}`).then(res=>console.log(res.data));
        }
        return todo;


      })
    });
  }

  delTodo=(id)=>{

    //axios.delete(`https://jsonplaceholder.typicode.com/todos/${id}`)
    axios.delete(`http://localhost:8181/api/vi/todo/${id}`)
    .then(res=>
      this.setState({
        todos:res.data
        //todos:this.state.todos.map();
        //todos:[...this.state.todos.filter(todo=>todo.id!==id)]
      }));
    ;
  }

  onClearState=()=>{
    this.setState({todos:[]})
  }

  addTodo=(title)=>{
    const newTodo={
      id:uuidv4(),
      title:title,
      completed:false
    }

    //axios.post('https://jsonplaceholder.typicode.com/todos',{
      axios.post('http://localhost:8181/api/vi/todo',{
      title:title,
      completed:false
    })
    .then(res=>{
      //this.onClearState();
      //res.data.map(dt=>console.log(dt));
      this.setState({todos:res.data});
    });
    //.then(res=>this.setState({todos:[...this.state.todos,res.data]}));
    //this.setState({todos:[...this.state.todos,newTodo]});
  }
  render(){
  return (
    <Router>
    <div className="App">
      <div className="container">
     <Header filerTodo={this.filerTodo} />
     <Route exact path="/" render={props=>(
       <React.Fragment>
         <AddTodo addTodo={this.addTodo}/>
        <Todos todos={this.state.todos} markComplete={this.markComplete} delTodo={this.delTodo}/>

      </React.Fragment>

     )}/>
     <Route path="/about" render={props=>(
       <React.Fragment>
         <About/>
       </React.Fragment>
     )

     } />
     
    </div>
    </div>
    </Router>
  );
  }
}

export default App;
