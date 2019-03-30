import { Observable, throwError } from 'rxjs';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { catchError, map } from 'rxjs/operators';
import { Injectable } from '@angular/core';

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};


@Injectable({
  providedIn: 'root'
})
export class PhotosService {

  constructor(private http: HttpClient) { }

  private handleError(error: HttpErrorResponse) {
    if (error.error instanceof ErrorEvent) {
      // A client-side or network error occurred. Handle it accordingly.
      console.error('An error occurred:', error.error.message);
    } else {
      // The backend returned an unsuccessful response code.
      // The response body may contain clues as to what went wrong,
      console.error(
        `Backend returned code ${error.status}, ` +
        `body was: ${error.error}`);
    }
    // return an observable with a Formation-facing error message
    return throwError('Something bad happened; please try again later.');
  }

  private extractData(res: Response) {
    const body = res;
    return body || { };
  }

  getFormationsPhotos(eventid): Observable<any> {
    return this.http.get('http://localhost:8080/eventphotos/' + eventid, httpOptions).pipe(
      map(this.extractData),
      catchError(this.handleError));
  }

  getProjetsPhotos(projectid): Observable<any> {
    return this.http.get('http://localhost:8080/projectphotos/' + projectid, httpOptions).pipe(
      map(this.extractData),
      catchError(this.handleError));
  }

  getNewsPhotos(newsid): Observable<any> {
    return this.http.get('http://localhost:8080/articlephotos/' + newsid, httpOptions).pipe(
      map(this.extractData),
      catchError(this.handleError));
  }


}
