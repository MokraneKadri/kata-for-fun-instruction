import { HttpClient } from '@angular/common/http';
import { Injectable , Inject} from '@angular/core';
import { Observable } from 'rxjs';
import { Result } from './model/result';

@Injectable({
  providedIn: 'root'
})
export class KataForFunService {

  private readonly apiPath = '/kata-for-fun';
  private url: string;

  constructor(@Inject('SERVER_URL') serverUrl: string, private httpClient: HttpClient) {
    this.url = serverUrl + this.apiPath;
  }


  public convertNumber(input: number ): Observable<Result>{
    return this.httpClient.get<Result>(this.url + '/' + input);
  }
}
