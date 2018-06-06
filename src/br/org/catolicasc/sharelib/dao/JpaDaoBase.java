package br.org.catolicasc.sharelib.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.Query;

import br.org.catolicasc.sharelib.bean.Bean;
import br.org.catolicasc.sharelib.jpa.JPAUtil;
import br.org.catolicasc.sharelib.jpa.QueryDataModel;

public abstract class JpaDaoBase<T extends Bean> implements Dao<T> {

	private final Class<T> classe;	

	@SuppressWarnings("unchecked")
	public JpaDaoBase() {
		this.classe = (Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}

	public void salva(T t) {
		if (t.getId() == null)
			JPAUtil.getEntityManager().persist(t);
		else
			JPAUtil.getEntityManager().merge(t);
	}

	public void remove(T t) {
		JPAUtil.getEntityManager().remove(this.buscaPorld(t.getId()));
	}

	public void atualiza(T t) {
		JPAUtil.getEntityManager().merge(t);
	}

	public List<T> listaTodos() {
		Query query = JPAUtil.getEntityManager().createQuery(getQueryAll());
		List<T> lista = query.getResultList();
		return lista;
	}

	public T buscaPorld(Long id) {
		return (T) JPAUtil.getEntityManager().find(classe, id);
	}

	public List<T> listaPaginada(int ini, int max) {
		Query query = JPAUtil.getEntityManager().createQuery(getQueryAll());
		query.setFirstResult(ini);
		query.setMaxResults(max);
		List<T> lista = query.getResultList();
		return lista;
	}
	
	public QueryDataModel<T> listaPaginadaLazy() {
		return new QueryDataModel<T>(getQueryAll());
	}

	protected String getQueryAll() {
		return "select t from " + classe.getName()+ " t ";
	}
	
}