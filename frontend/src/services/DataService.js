import http from "./http-common";

class DataServices {
  getAll(path) {
    return http.get(`/${path}`);
  }

  getOne(path, id) {
    return http.get(`/${path}/${id}`);
  }

  createUser(path, data) {
    return http.post(`/${path}`, data);
  }
  create(path, data) {
    return http.post(`/${path}`, data);
  }

  update(path, id, data) {
    return http.put(`/${path}/${id}`, data);
  }

  deleteUser(path, id) {
    return http.delete(`/${path}/${id}`);
  }
  getPersonalInfo(path) {
    return http.get(`/${path}`);
  }
  getEducation(path) {
    return http.get(`/${path}`);
  }
  getWrodks(path) {
    return http.get(`/${path}`);
  }
  getAddress(path) {
    return http.get(`/${path}`);
  }
}

export default new DataServices();
