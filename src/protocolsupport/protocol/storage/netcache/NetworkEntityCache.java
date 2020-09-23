package protocolsupport.protocol.storage.netcache;

import java.util.ArrayList;
import java.util.List;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import protocolsupport.protocol.types.networkentity.NetworkEntity;
import protocolsupport.utils.Utils;

public class NetworkEntityCache {

	protected final Int2ObjectMap<NetworkEntity> entities = new Int2ObjectOpenHashMap<>();
	protected NetworkEntity player;

	public void setSelf(NetworkEntity player) {
		this.player = player;
		addEntity(player);
	}

	public NetworkEntity getSelf() {
		return player;
	}

	public int getSelfId() {
		return player != null ? player.getId() : -1;
	}

	public void addEntity(NetworkEntity entity) {
		entities.put(entity.getId(), entity);
	}

	public NetworkEntity getEntity(int entityId) {
		return entities.get(entityId);
	}

	public List<NetworkEntity> getEntities(int... entityIds) {
		if (entityIds.length == 0) {
			return new ArrayList<>();
		}
		List<NetworkEntity> result = new ArrayList<>(entityIds.length);
		for (int entityId : entityIds) {
			NetworkEntity entity = entities.get(entityId);
			if (entity != null) {
				result.add(entity);
			}
		}
		return result;
	}

	public List<NetworkEntity> popEntities(int[] entityIds) {
		if (entityIds.length == 0) {
			return new ArrayList<>();
		}
		List<NetworkEntity> result = new ArrayList<>(entityIds.length);
		for (int entityId : entityIds) {
			NetworkEntity entity = entities.remove(entityId);
			if (entity != null) {
				result.add(entity);
			}
		}
		readdSelf();
		return result;
	}

	public void removeEntities(int[] entityIds) {
		for (int entityId : entityIds) {
			entities.remove(entityId);
		}
		readdSelf();
	}

	public void clearEntities() {
		entities.clear();
		readdSelf();
	}

	private void readdSelf() {
		if (player != null) {
			addEntity(player);
		}
	}

	@Override
	public String toString() {
		return Utils.toStringAllFields(this);
	}

}
