import { Course } from '../course/course.model';
import { User } from '../user/user.model';

export interface Schedule {
    scheduleId: number;
    shedule: string;
    listUsers: User[]; //supongo que es una lista de string
    course: Course;
}
