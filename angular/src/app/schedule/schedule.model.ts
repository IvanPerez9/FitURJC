import { Course } from '../course-profile/course-profile.model';
import { User } from '../user/user.model';

export interface Schedule {
    idSchedule: number;
    schedule: string;
    listUsers: User[];
    course: Course;
    full: boolean;
}
