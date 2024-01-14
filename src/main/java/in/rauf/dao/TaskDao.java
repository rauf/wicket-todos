package in.rauf.dao;

import in.rauf.entities.TaskEntity;
import in.rauf.models.TaskStatus;
import jakarta.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;

public class TaskDao extends BaseDao<TaskEntity, Long> {

    public void updateStatus(Long id, TaskStatus taskStatus) {
        if (id == null || taskStatus == null) {
            return;
        }

        var taskEntity = findById(id);
        var entityManager = getEntityManager();
        entityManager.getTransaction().begin();

        if (taskEntity.isEmpty()) {
            return;
        }

        taskEntity.get().setStatus(taskStatus);
        entityManager.merge(taskEntity.get());
        entityManager.getTransaction().commit();
    }

    @Transactional
    public void delete(Long id) {
        if (id == null) {
            return;
        }
        findById(id).ifPresent(e -> {
//            if (e.getProperty() != null) {
//                e.getProperty().setTasks(null);
//            }
//            if (e.getAssignedTo() != null) {
//                e.getAssignedTo().setTasks(null);
//            }
//            e.setProperty(null);
//            e.setAssignedTo(null);
            remove(e);
        });
    }

    public List<TaskEntity> findAllFor(Long propertyId, Long userId) {
        var entityManager = getEntityManager();
        var conditions = new ArrayList<String>();

        var query = new StringBuilder("FROM TaskEntity t");

        if (propertyId != null || userId != null) {
            query.append(" WHERE");
        }
        if (propertyId != null) {
            conditions.add(" t.property.id = :propertyId");
        }
        if (userId != null) {
            conditions.add(" t.assignedTo.id = :userId");
        }

        query.append(String.join(" AND", conditions));

        var q = entityManager.createQuery(query.toString(), TaskEntity.class);

        if (propertyId != null) {
            q.setParameter("propertyId", propertyId);
        }
        if (userId != null) {
            q.setParameter("userId", userId);
        }
        return q.getResultList();
    }
}
