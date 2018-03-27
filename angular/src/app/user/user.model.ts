export interface User {
    userId: number;
    admin?: boolean;
    email: string;
    favouriteCategories?: string[];
    nick: string;
    photo?: string;
    roles?: string[];
    favMovies?: any[];
} 
