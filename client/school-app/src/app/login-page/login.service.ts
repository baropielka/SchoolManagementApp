import { Injectable } from '@angular/core';
import * as bcrypt from 'bcryptjs';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor() { }

  async hashPassword(password: string): Promise<string> {
    return bcrypt.hash(password, 10);
  }
}
