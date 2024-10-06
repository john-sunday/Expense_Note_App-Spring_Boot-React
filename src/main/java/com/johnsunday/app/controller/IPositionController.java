package com.johnsunday.app.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.johnsunday.app.entity.Position;

public interface IPositionController<Position> {

	public ResponseEntity<?> getAllPosition();

	public ResponseEntity<?> getPositionById(@PathVariable Integer positionId);

	public ResponseEntity<?> savePosition(@RequestBody @Valid Position position);

	public ResponseEntity<?> updatePosition(@RequestBody @Valid Position position,
			@PathVariable Integer positionId);

	public ResponseEntity<?> deletePosition(@PathVariable Integer positionId);
}
