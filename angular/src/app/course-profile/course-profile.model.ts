export interface Course {
    courseId: number;
    src: string;
    name: string;
    category: Category;
    description: string;
    schedules: string[];
}

export enum Category {
	STRENGTH,
	CARDIO,
	FREESTYLE,
	DANCE,
	MIND
}
