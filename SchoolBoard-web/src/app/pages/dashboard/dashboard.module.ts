import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { AppTranslationModule } from '../../app.translation.module';
import { NgaModule } from '../../theme/nga.module';

import { Dashboard } from './dashboard.component';
import { routing } from './dashboard.routing';

import { PopularApp } from './popularApp';

import { UsersMap } from './usersMap';
import { LineChart } from './lineChart';
import { Feed } from './feed';
import { Todo } from './todo';
import { FeedService } from './feed/feed.service';
import { LineChartService } from './lineChart/lineChart.service';

import { TodoService } from './todo/todo.service';

import { UsersMapService } from './usersMap/usersMap.service';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    AppTranslationModule,
    NgaModule,
    routing
  ],
  declarations: [
    PopularApp,
    
    UsersMap,
    LineChart,
    Feed,
    Todo,
    Dashboard
  ],
  providers: [
    FeedService,
    LineChartService,
   
    TodoService,
    
    UsersMapService
  ]
})
export class DashboardModule {}
