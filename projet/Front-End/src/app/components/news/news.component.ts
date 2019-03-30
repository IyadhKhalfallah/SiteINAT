import { Component, OnInit } from '@angular/core';
import { NewService } from 'src/app/services/new.service';
import { PhotosService } from 'src/app/services/photos.service';

@Component({
  selector: 'app-news',
  templateUrl: './news.component.html',
  styleUrls: ['./news.component.css']
})
export class NewsComponent implements OnInit {

  p = 1; // current page
  news = [
    // tslint:disable-next-line:max-line-length
    {id: 1, date: '14-11-2018', title: 'news 1', description: 'description new 1', image: 'affiche/forum-6Affiche.jpg'},
  ];
  constructor(private newsService: NewService, private photoService: PhotosService) { }

  ngOnInit() {
     this.newsService.getNews().subscribe(data => {
       if (data) {
         for (let i = 0; i < 4; i++) {
           this.photoService
             .getNewsPhotos(data[i].newsid)
             .subscribe(photos => {
                 const news = {
                   id: data[i].newsid,
                   title: data[i].name,
                   description: data[i].description,
                   date: data[i].date,
                   image: data[i].path
                 };
                 this.news.push(news);
             });
         }
       }
     });
    }

}
