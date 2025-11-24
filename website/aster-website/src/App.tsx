import { Outlet } from "react-router-dom"
import NavTop from "./components/NavTop"
import { useState } from "react"

function App() {

  const [ navColor, setNavColor ] = useState('transparent')

  

  return (
    <div>
      <NavTop backgroundColor={navColor} />
      <main className="w-full h-full min-h-screen min-w-screen" >
        <Outlet context={{setNavColor}}/>
      </main>
    </div>
  )
}

export default App
