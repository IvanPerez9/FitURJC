import { Course } from '../course-profile/course-profile.model';
import { User } from '../user/user.model';

const MAXCAPACITY = 3;

export interface Schedule {
    idSchedule: number;
    schedule: string;
    listUsers: User[];
    course: Course;
    signup: boolean;
}
