import { DatePipe } from "@angular/common";
export class Order{

bookingOrderId: number;
orderDate: DatePipe;
transactionMode: string;
quantity: number;
totalCost: number;
}