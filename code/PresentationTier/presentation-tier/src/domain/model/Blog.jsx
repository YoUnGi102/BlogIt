export interface Blog{
    id?:int;
    name?:string;
    description?:string;
    access?:string;
    rating?:number;
    dateTimeCreated?:Date;
    lastUpdated?:Date;
    posts?:int;
    comments?:int;
    likes?:int;
    dislikes?:int;
}

export const EMPTY_BLOG = {
    "id": 0,
    "name":"",
    "description":"",
    "access":"",
    "rating":0,
    "dateTimeCreated":null,
    "lastUpdated":null,
    "posts": 0,
    "comments": 0,
    "likes": 0,
    "dislikes": 0
}