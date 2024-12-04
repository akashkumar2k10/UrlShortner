export const defaultNacList : NavItem[]=[
    {
        id:1,
        name:"Home",
        path : "home/dashborad"
    },
    {
        id:2,
        name:"Links",
        path : "home/link"
    },
    {
        id:3,
        name:"Custom Link",
        path : "home/custom-link"
    }
]



export interface NavItem{
    id : number;
    name : string;
    path : string;
}