import React, { Component } from 'react'
import {Link} from 'react-router-dom';
import PropTypes from 'prop-types';


class Header extends Component {
//function Header() {
    searchTitles=(e)=>{        
        this.props.filerTodo(e.target.value); 
   }
    render(){
    
        return (
           <header style={headerStyle}>
               <h1>TodoList</h1>
               <Link style={linkStyle} to="/">Home</Link> | <Link style={linkStyle} to="/about">About</Link>
               <input type="text" style={{float:"right"}} placeholder="Enter Search key..." onKeyUp={this.searchTitles}/>
            </header>
                
            
        )}

}

const linkStyle={
    color:'#fff',
    textDecoration:'none'
}

const headerStyle={
    background:'#333',
    color:'#fff',
    textAlign:'center',
    padding:'10px'
}



Header.propTypes = {
    filerTodo: PropTypes.func.isRequired,
    
}

export default Header;