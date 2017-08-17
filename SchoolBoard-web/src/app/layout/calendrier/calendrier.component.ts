import {CalendarComponent} from "ap-angular2-fullcalendar";
 
@Component({
  selector: 'app-calendrier',
  templateUrl: './calendrier.html'
})
export class CalendarComponent{
  
    calendarOptions:Object = {
        height: 'parent',
        fixedWeekCount : false,
        defaultDate: '2016-09-12',
        editable: true,
        eventLimit: true,
        events :[ ]
  };
}


        