package ir.gamesi.ejb.dao.base;
import ir.gamesi.ejb.model.BaseEntity;
import ir.gamesi.ejb.model.Product;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public abstract class BaseDaoImpl<T extends BaseEntity>{


    @PersistenceContext(unitName="aliUnit")
    protected EntityManager em;

    private Class<T> modelClass;

    private String className;



    public void setModelClass(Class<T> modelClass) {
        this.modelClass = modelClass;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Optional<T> findById(Long id){
        if(id!=null) {
            T entity = em.find(modelClass, id);
            return entity != null ? Optional.of(entity) : Optional.empty();
        }else return Optional.empty();
    }
    @Transactional(Transactional.TxType.REQUIRED)
    public Optional<T> save(T entity) throws Exception {
        try {
            if (entity.getId() == null) {
                em.persist(entity);
            } else {
                entity = em.merge(entity);
            }
            return Optional.of(entity);
        }catch (Exception e){
            throw new Exception();
        }
    }
    public Long delete(T entity){
        Optional<T> product1 = findById(entity.getId());
        if(product1.isPresent())
            em.remove(product1.get());
        return entity.getId();
    }

    public List<T> findAll(){
        String q = "select p from " + modelClass.getName() +" p";
        StringBuilder queryBuilder =new StringBuilder(q);
        Query query = em.createQuery(q,modelClass);
        return query.getResultList();
    }

    public List<T> search(int offset, int pageSize, Map<String, String> sortBy, Map<String, String> filterBy) {
        String q = "select e from "+ this.className +  " e where 1=1\n";
        StringBuilder queryStatement = new StringBuilder(q);
        if(filterBy.size()>0){
            filterBy.forEach((k,v) ->{
                queryStatement.append(" and e." + k + " like :v_" + k + " \n");
            });
        }
        if(sortBy.size()>0) queryStatement.append("order by ");
        sortBy.forEach((k,v)->{
            queryStatement.append("e." + k + " ");
            if(v.equals("ASCENDING"))
            queryStatement.append("ASC");
            else
            queryStatement.append("DESC");
        });
        Query query = em.createQuery(queryStatement.toString(), this.modelClass);
        if(filterBy.size()>0){
            filterBy.forEach((k,v) ->{
                query.setParameter("v_" + k ,"%" + v + "%");
            });
        }
        query.setFirstResult(offset);
        query.setMaxResults(pageSize);
        List<T> entities = query.getResultList();
        return entities;
    }

    public int countEntity() {
        String q = "select count(*) as count from " + className;
        StringBuilder queryBuilder =new StringBuilder(q);
        Long count = (Long) em.createNativeQuery(queryBuilder.toString()).getSingleResult();
        return count.intValue();
    }

}