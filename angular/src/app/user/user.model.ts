export interface User {
    userId: number;
    admin?: boolean;
    email: string;
    name: string;
    nickname: string;
    password?: string;
    surname: string;
    photo?: string;
    roles: string[];
}
