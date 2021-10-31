package com.usa.reto3.service;

import com.usa.reto3.model.Room;
import com.usa.reto3.repository.RoomRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author nbsc1
 */
@Service
public class RoomService {

    @Autowired

    private RoomRepository crudMetodos;

    public List<Room> getAll() {
        return crudMetodos.getAll();
    }

    public Optional<Room> getRoom(int roomId) {
        return crudMetodos.getRoom(roomId);
    }

    public Room save(Room room) {
        if (room.getId() == null) {
            return crudMetodos.save(room);

        } else {

            Optional<Room> evt = crudMetodos.getRoom(room.getId());
            if (evt.isEmpty()) {
                return crudMetodos.save(room);

            } else {
                return room;

            }

        }

    }

}
