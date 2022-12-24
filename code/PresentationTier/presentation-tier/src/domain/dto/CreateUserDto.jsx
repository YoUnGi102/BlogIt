export interface CreateUserDto{
    username:string,
    email:string,
    password:string,
    repeatPassword:string
}

export const EMPTY_CREATE_USER_DTO : CreateUserDto = {
    username: "",
    email: "",
    password: "",
    repeatPassword: ""
}