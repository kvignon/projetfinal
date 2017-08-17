import {CalendarComponent} from "ap-angular2-fullcalendar";

 
export class CalendarComponent{
  @ViewChild(CalendarComponent) myCalendar: CalendarComponent;
 
  changeCalendarView(view) {
    this.myCalendar.fullCalendar('changeView', view);
  }