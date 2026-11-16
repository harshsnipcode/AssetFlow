import axios from 'axios';

const api = axios.create({
  baseURL: `${import.meta.env.VITE_API_URL || 'http://localhost:8081'}/api`,
  headers: { 'Content-Type': 'application/json' },
});
const request = async (promise) => (await promise).data;

export const apiService = {
  dashboard: () => request(api.get('/dashboard/stats')),
  employees: { list: () => request(api.get('/employees')), get: (id) => request(api.get(`/employees/${id}`)), create: (data) => request(api.post('/employees', data)), update: (id, data) => request(api.put(`/employees/${id}`, { ...data, id })), remove: (id) => api.delete(`/employees/${id}`) },
  assets: { list: () => request(api.get('/assets')), available: () => request(api.get('/assets/available')), get: (id) => request(api.get(`/assets/${id}`)), create: (data) => request(api.post('/assets', data)), update: (id, data) => request(api.put(`/assets/${id}`, { ...data, id })), remove: (id) => api.delete(`/assets/${id}`) },
  allocations: { list: () => request(api.get('/allocations')), create: (data) => request(api.post('/allocations', data)), returnAsset: (id) => request(api.put(`/allocations/${id}/return`)) },
  tickets: { list: () => request(api.get('/tickets')), get: (id) => request(api.get(`/tickets/${id}`)), create: (data) => request(api.post('/tickets', data)), updateStatus: (id, status, note) => request(api.put(`/tickets/${id}/status`, { status, note })) },
  requests: { list: () => request(api.get('/asset-requests')), create: (data) => request(api.post('/asset-requests', data)), approve: (id) => request(api.put(`/asset-requests/${id}/approve`)), reject: (id) => request(api.put(`/asset-requests/${id}/reject`)) },
};
export const getApiError = (error) => error?.response?.data?.message || error?.message || 'Something went wrong.';
