import { Course } from '../course/course.model';
import { User } from '../user/user.model';

const MAXCAPACITY = 3;

export interface Schedule {
    scheduleId: number;
    shedule: string;
    listUsers: User[]; 
    course: Course;
    signup: boolean;
}
