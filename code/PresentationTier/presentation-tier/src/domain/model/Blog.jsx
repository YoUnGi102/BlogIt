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