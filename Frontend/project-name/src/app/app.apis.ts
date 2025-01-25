import { env as host } from './../enviroments/enviroment';

export const apis = {
  login: `${host.url}/api/auth/login`,
  userInfo: `${host.url}/api/auth/userInfo`,
  logout: `${host.url}/api/auth/logout`,

  link: `${host.url}/api/url`,
  customLink: `${host.url}/api/custom/url`,
  qrCode: `${host.url}/api/Qr`,
};
