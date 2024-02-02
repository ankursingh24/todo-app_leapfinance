
import './App.css';
import AddListComponent from './component/AddListComponent';

import FooterC from './component/FooterC';
import Header from './component/Header';
import ListComponent from './component/ListComponent';
 import {BrowserRouter,Routes,Route} from 'react-router-dom'
function App() { 
  return (
<div>
  <BrowserRouter>
 <Header/>
 <Routes>
<Route path='/' element={ <ListComponent/>}></Route>
<Route path='/lists' element={ <ListComponent/>}></Route>
<Route path='/add-task' element={<AddListComponent/>}></Route>
<Route path='/edit-task/:id' element={<AddListComponent/>}></Route>
 </Routes>
 
  <FooterC/>
  </BrowserRouter>

    </div>
  );
}

export default App;
