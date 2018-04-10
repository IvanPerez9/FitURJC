import { Course } from '../course/course.model';

export interface Schedule {
    scheduleId: number;
    shedule: string;
    listUsers: string[]; //supongo que es una lista de string
    course: Course;
}