export interface User {
    id: number;
    admin?: boolean;
    email: string;
    name: string;
    surname: string;
    nickname: string;
    age: number;
    passwordHash?: string;
    imgSrc?: string;
    roles: string[];
}
