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
  news = [];
  constructor(private newsService: NewService, private photoService: PhotosService) { }

  ngOnInit() {
    this.newsService.getNews().subscribe(data => {
      if (data) {
        for (let i = 0; i < 4; i++) {
          this.photoService
            .getNewsPhotos(data[i].articleid)
            .subscribe(photos => {
              const news = {
                id: data[i].articleid,
                title: data[i].name,
                description: data[i].shortdescription,
                date: data[i].date.substr(0, 10),
                image: photos[0].path
              };
              this.news.push(news);
            });
        }
      }
    });
  }

}
