import { AddressDetailsTo } from "./AddressDetails";
import { TeacherDetailsTo } from "./TeacherDetails";

export interface SchoolDetailsSto {
    name: string;
    email: string;
    phoneNumber: string;
    schoolType: string;
    address: AddressDetailsTo;
    headTeacher: TeacherDetailsTo;
}
