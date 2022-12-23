import './App.css';
import BlogsPage from "./pages/BlogsPage";
import CreateBlog from "./components/CreateBlog";
import ViewBlogPage from "./pages/ViewBlogPage";
import {createBrowserRouter, RouterProvider} from "react-router-dom";

function App() {

    const router = createBrowserRouter([
        {
            path: "/",
            element: <BlogsPage />,
        },
        {
            path: "blogs/:blogId",
            element: <ViewBlogPage />
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
