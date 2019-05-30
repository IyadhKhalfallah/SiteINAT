import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { FooterComponent } from './components/footer/footer.component';
import { HomeComponent } from './components/home/home.component';
import { ProjectsComponent } from './components/projects/projects.component';
import { EventsComponent } from './components/events/events.component';
import { FormationsComponent } from './components/formations/formations.component';
import { ContactComponent } from './components/contact/contact.component';
import { AboutUsComponent } from './components/about-us/about-us.component';
import { SponsorsPartenaireComponent } from './components/sponsors-partenaire/sponsors-partenaire.component';
import { StructureComponent } from './components/structure/structure.component';
import { RseComponent } from './components/rse/rse.component';
import { FormsModule } from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';
import { NotFoundComponent } from './components/not-found/not-found.component';
import { DetailsEventComponent } from './components/events/details-event/details-event.component';
import { DetailsProjectComponent } from './components/projects/details-project/details-project.component';
import { DetailsFormationComponent } from './components/formations/details-formation/details-formation.component';
import {NgxPaginationModule} from 'ngx-pagination';
import { SliderComponent } from './components/slider/slider.component';
import { HttpClientModule } from '@angular/common/http';
import { ActualitesComponent } from './components/actualites/actualites.component';
import { NewsComponent } from './components/news/news.component';
import { NewsDetailsComponent } from './components/news/news-details/news-details.component';
import { FacebookModule } from 'ngx-facebook';

const routes: Routes = [
  {path: '' , component: HomeComponent},
  {path: 'home' , component: HomeComponent},
  {path: 'projects' , component: ProjectsComponent},
  {path: 'projects/:id' , component: DetailsProjectComponent},
  {path: 'events' , component: EventsComponent},
  {path: 'events/:id' , component: DetailsEventComponent},
  {path: 'formations' , component: FormationsComponent},
  {path: 'formations/:id' , component: DetailsFormationComponent},
  {path: 'contact' , component: ContactComponent},
  {path: 'aboutUs' , component: AboutUsComponent},
  {path: 'sponsors' , component: SponsorsPartenaireComponent},
  {path: 'news' , component: NewsComponent},
  {path: 'news/:id' , component: NewsDetailsComponent},
  {path: 'structure' , component: StructureComponent},
  {path: 'rse' , component: RseComponent},

  {path: '**' , component: NotFoundComponent},
];

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    FooterComponent,
    HomeComponent,
    ProjectsComponent,
    EventsComponent,
    FormationsComponent,
    ContactComponent,
    AboutUsComponent,
    SponsorsPartenaireComponent,
    StructureComponent,
    RseComponent,
    NotFoundComponent,
    DetailsEventComponent,
    DetailsProjectComponent,
    DetailsFormationComponent,
    SliderComponent,
    ActualitesComponent,
    NewsComponent,
    NewsDetailsComponent
  ],
  imports: [
    NgxPaginationModule,
    RouterModule.forRoot(routes, {scrollPositionRestoration: 'enabled'}),
    BrowserModule,
    FormsModule,
    HttpClientModule,
      FacebookModule.forRoot()
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
