import { useState } from 'react';
import { Link } from 'react-router-dom';
import { Search, X, LoaderCircle, AlertCircle, CheckCircle2 } from 'lucide-react';

export function Loading({ label = 'Loading data…' }) { return <div className="state"><LoaderCircle className="spin" size={20} />{label}</div>; }
export function Empty({ title = 'Nothing here yet', description = 'Create your first record to get started.' }) { return <div className="state empty-state"><div className="empty-icon"><Search size={18} /></div><strong>{title}</strong><span>{description}</span></div>; }
export function ErrorState({ message, onRetry }) { return <div className="state error-state"><AlertCircle size={20} /><span>{message}</span>{onRetry && <button className="btn btn-secondary" onClick={onRetry}>Retry</button>}</div>; }
export function Toast({ toast, onClose }) { if (!toast) return null; return <div className={`toast ${toast.type}`}><CheckCircle2 size={17} />{toast.message}<button onClick={onClose}><X size={15} /></button></div>; }
export function StatusBadge({ value }) { return <span className={`badge ${String(value || '').toLowerCase()}`}>{String(value || '').replaceAll('_', ' ')}</span>; }
export function PageHeader({ eyebrow, title, description, action }) { return <div className="page-header"><div><p className="eyebrow">{eyebrow}</p><h1>{title}</h1>{description && <p className="muted">{description}</p>}</div>{action}</div>; }
export function Toolbar({ search, setSearch, searchPlaceholder = 'Search records…', children }) { return <div className="toolbar"><label className="search"><Search size={17} /><input value={search} onChange={(e) => setSearch(e.target.value)} placeholder={searchPlaceholder} /></label>{children}</div>; }
export function Modal({ title, onClose, children, wide = false }) { return <div className="modal-backdrop" onMouseDown={(e) => e.target === e.currentTarget && onClose()}><div className={`modal ${wide ? 'modal-wide' : ''}`}><div className="modal-header"><h2>{title}</h2><button className="icon-btn" onClick={onClose} aria-label="Close"><X size={18} /></button></div>{children}</div></div>; }
export function Confirm({ title, description, confirmLabel = 'Confirm', onClose, onConfirm, busy }) { return <Modal title={title} onClose={onClose}><p className="modal-copy">{description}</p><div className="modal-actions"><button className="btn btn-secondary" onClick={onClose}>Cancel</button><button className="btn btn-danger" onClick={onConfirm} disabled={busy}>{busy ? 'Working…' : confirmLabel}</button></div></Modal>; }
export function FormField({ label, error, children, required = false }) { return <label className="field"><span>{label}{required && <em> *</em>}</span>{children}{error && <small className="field-error">{error}</small>}</label>; }
export function FormActions({ onCancel, busy, label = 'Save changes' }) { return <div className="form-actions"><button type="button" className="btn btn-secondary" onClick={onCancel}>Cancel</button><button className="btn btn-primary" disabled={busy}>{busy ? 'Saving…' : label}</button></div>; }
export function DetailLink({ to, children }) { return <Link className="text-link" to={to}>{children}</Link>; }
