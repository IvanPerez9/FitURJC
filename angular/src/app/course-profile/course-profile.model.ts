import { Schedule } from "../schedule/schedule.model";

export interface Course {
    id: number;
    src: string;
    name: string;
    category: Category;
    description: string;
    schedules: Schedule[];
}

export enum Category {
	STRENGTH,
	CARDIO,
	FREESTYLE,
	DANCE,
	MIND
}
