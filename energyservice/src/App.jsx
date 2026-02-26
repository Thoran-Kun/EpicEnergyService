import 'bootstrap/dist/css/bootstrap.min.css'
import  FormLogin from "./components/FormLogin"
import './App.css'
import { BrowserRouter,Routes ,Route } from 'react-router-dom'
import Table from './components/Table'
function App() {
  

  return (
    <>
        <BrowserRouter>
          <Routes>
            <Route path="/" element={<FormLogin />} />
            <Route path="/pagina2" element={<Table />} />
          </Routes>
        </BrowserRouter>
       
    </>
  )
}

export default App
