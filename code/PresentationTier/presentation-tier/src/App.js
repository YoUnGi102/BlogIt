import './App.css';
import BlogsPage from "./components/BlogsPage";
import CreateBlog from "./components/CreateBlog";
import {createBrowserRouter, RouterProvider} from "react-router-dom";

function App() {

    const router = createBrowserRouter([
        {
            path: "/",
            element: <BlogsPage />,
        },
        {
            path: "blogs/create",
            element: <CreateBlog/>
        }
    ]);
    return (
    <div className="App">
        <RouterProvider router={router} />
    </div>
);
}

export default App;
