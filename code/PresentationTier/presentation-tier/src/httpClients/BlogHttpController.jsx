export class BlogHttpController {

    api_path = "localhost:8080/api/v1/blogs";

    constructor() {}

    async postBlog(dto: CreateBlogDto){
        return await fetch(
            this.api_path,
            {
                method: 'post',
                headers: { 'Content-Type': 'application/json' },
                body: dto,
            }
        )
    }
}