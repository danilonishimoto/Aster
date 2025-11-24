import { Outlet } from "react-router-dom"

function App() {

  return (
    <div>
{/* <div className="w-full h-full min-h-screen min-w-screen flex flex-row items-start justify-start">
        <h1>Aster Website</h1>
      </div> */}
      <main className="w-full h-full min-h-screen min-w-screen">
        <Outlet />
      </main>
    </div>
  )
}

export default App
