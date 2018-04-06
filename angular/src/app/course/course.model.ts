export interface Course {
    courseId: number;
    src: string;
    name: string;
    category: Category;
    description: string;
    schedule: string[];
}

export enum Category {
	STRENGTH,
	CARDIO,
	FREESTYLE,
	DANCE,
	MIND
}
